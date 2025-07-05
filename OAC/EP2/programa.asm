.data
array:       .space 400           # espaco para 100 floats (dps a gente aumenta)
msg_sorted:  .asciiz "Valores ordenados:\n"
filename:    .asciiz "entrada.txt"
buffer:      .space 1024
newline:     .byte 10
msg_print:   .asciiz "Valores lidos:\n"
zero_float:  .float 0.0

.text
.globl main

main:
	# abrir arquivo
	li   $v0, 13
	la   $a0, filename
	li   $a1, 0
	li   $a2, 0
	syscall
	addu $s0, $v0, $zero

	# ler 
	li   $v0, 14
	addu $a0, $s0, $zero
	la   $a1, buffer
	li   $a2, 1024
	syscall
	addu $s1, $v0, $zero

	#fechar 
	li   $v0, 16
	addu $a0, $s0, $zero
	syscall

	#Fiz flags para ficar conferindo no que eu estou lendo pra não ter q fazer um milhão de brench
	la   $t0, buffer         # ponteiro do buffer
	la   $t1, array          # ponteiro do array
	li   $t2, 0              # parte inteira
	li   $t3, 0              # flag decimal
	li   $t4, 1              # divisor decimal
	li   $t5, 0              # parte decimal
	li   $t6, 0              # negativo
	li   $t7, 0              # contador de bytes

read_loop:
	bge  $t7, $s1, fim_conversao_dados
	lb   $t8, 0($t0)

	li   $s2, 10 #Cabou
	beq  $t8, $s2, salvar_numero

	li   $s2, 45  #Acha o -
	beq  $t8, $s2, negativo

	li   $s2, 46 #Acha o .
	beq  $t8, $s2, ponto

	li   $s2, 48 #Pra idenficiar o inteiro
	sub  $t8, $t8, $s2
	beq  $t3, $zero, int

	# parte decimal
	li   $t9, 10
	mul  $t5, $t5, $t9
	add  $t5, $t5, $t8
	mul  $t4, $t4, $t9
	addi $t0, $t0, 1
	addi $t7, $t7, 1
	j read_loop

int:
	li   $t9, 10
	mul  $t2, $t2, $t9
	add  $t2, $t2, $t8
	addi $t0, $t0, 1
	addi $t7, $t7, 1
	j read_loop

negativo:
	li   $t6, 1
	addi $t0, $t0, 1
	addi $t7, $t7, 1
	j read_loop

ponto:
	li   $t3, 1
	addi $t0, $t0, 1
	addi $t7, $t7, 1
	j read_loop

salvar_numero: #faz todas as converções
	mtc1 $t2, $f2 
	cvt.s.w $f2, $f2
	mtc1 $t5, $f4
	cvt.s.w $f4, $f4
	mtc1 $t4, $f6
	cvt.s.w $f6, $f6
	div.s $f4, $f4, $f6
	add.s $f12, $f2, $f4

	beq  $t6, $zero, armazena_valor
	neg.s $f12, $f12 #mutiplica por -1





armazena_valor:

	s.s  $f12, 0($t1) #Guarda
	addi $t1, $t1, 4
	li $t2, 0
	li $t3, 0
	li $t4, 1
	li $t5, 0
	li $t6, 0
	addi $t0, $t0, 1
	addi $t7, $t7, 1
	j read_loop

fim_conversao_dados: 
	or $s5, $t2, $t5 #Conferir int ou float
	beq $s5, $zero, pula_salvamento_final

	mtc1 $t2, $f2
	cvt.s.w $f2, $f2
	mtc1 $t5, $f4
	cvt.s.w $f4, $f4
	mtc1 $t4, $f6
	cvt.s.w $f6, $f6
	div.s $f4, $f4, $f6
	add.s $f12, $f2, $f4
	beq $t6, $zero, armazena_valor_final
	neg.s $f12, $f12

armazena_valor_final:
	s.s  $f12, 0($t1)
	addi $t1, $t1, 4

pula_salvamento_final:
	li $v0, 4
	la $a0, msg_print
	syscall

	la $s3, array
	sub $s4, $t1, $s3
	li $t9, 4
	divu $s4, $s4, $t9
	li $t9, 0

print_loop:
	bge $t9, $s4, chama_ordena 
	lwc1 $f12, 0($s3)
	li $v0, 2
	syscall
	li $v0, 11
	li $a0, 10
	syscall
	addi $s3, $s3, 4
	addi $t9, $t9, 1
	j print_loop

chama_ordena: #Chamada da função de fato
	addu $a0, $s4, $zero 	#numero de elementos
	li   $a1, 1 			#tipo, Aqui especifica se é insertion ou se é quick
	la   $a2, array			#array
	jal ordena

	addu $s3, $v0, $zero
	li $v0, 4
	la $a0, msg_sorted
	syscall
	li $t9, 0

print_sorted_loop:
	bge $t9, $s4, fim_programa
	lwc1 $f12, 0($s3)
	li $v0, 2
	syscall
	li $v0, 11
	li $a0, 10
	syscall
	addi $s3, $s3, 4
	addi $t9, $t9, 1
	j print_sorted_loop

fim_programa:
	li $v0, 10
	syscall


# ORDENAÇÃO
ordena:
	beq $a1, $zero, quicksort # tipo 0 chama quicksort

	#Pilha generica da função (dá pra diminuir se quiser)
	addi $sp, $sp, -32
	sw $ra, 0($sp)
	sw $s0, 4($sp)
	sw $s1, 8($sp)
	sw $s2, 12($sp)
	sw $s3, 16($sp)
	sw $s4, 20($sp)
	sw $s5, 24($sp)
	sw $s6, 28($sp)

	add $s0, $a0, $zero       
	add $s1, $a1, $zero       
	add $s2, $a2, $zero       

	li $s3, 1

ordena_outer_loop:
	bge $s3, $s0, ordena_fim
	mul $t0, $s3, 4
	add $t0, $s2, $t0
	lwc1 $f20, 0($t0)
	addi $s4, $s3, -1

ordena_inner_loop:
	slt $at, $s4, $zero   
	bne $at, $zero, ordena_end_inner #Se for zero vai pro ordena
	mul $t1, $s4, 4
	add $t1, $s2, $t1
	lwc1 $f22, 0($t1)
	c.le.s $f20, $f22
	bc1t ordena_end_inner
	addi $t2, $t1, 4
	s.s $f22, 0($t2)
	addi $s4, $s4, -1
	j ordena_inner_loop

ordena_end_inner:
	addi $t3, $s4, 1
	mul $t3, $t3, 4
	add $t3, $s2, $t3
	s.s $f20, 0($t3)
	addi $s3, $s3, 1
	j ordena_outer_loop

ordena_fim:
	add $v0, $s2, $zero       
	lw $ra, 0($sp)
	lw $s0, 4($sp)
	lw $s1, 8($sp)
	lw $s2, 12($sp)
	lw $s3, 16($sp)
	lw $s4, 20($sp)
	lw $s5, 24($sp)
	lw $s6, 28($sp)
	addi $sp, $sp, 32
	jr $ra

quicksort:
	##FA>TA IMPLEMENTAR , SÓ COPIEI A STACK
	
	addi $sp, $sp, -32
	sw $ra, 0($sp)
	sw $s0, 4($sp)
	sw $s1, 8($sp)
	sw $s2, 12($sp)
	sw $s3, 16($sp)
	sw $s4, 20($sp)
	sw $s5, 24($sp)
	sw $s6, 28($sp)

	add $s0, $a0, $zero       
	add $s1, $a1, $zero      
	add $s2, $a2, $zero      

	li $s3, 1

	add $v0, $s2, $zero       
	
	lw $ra, 0($sp)
	lw $s0, 4($sp)
	lw $s1, 8($sp)
	lw $s2, 12($sp)
	lw $s3, 16($sp)
	lw $s4, 20($sp)
	lw $s5, 24($sp)
	lw $s6, 28($sp)
	addi $sp, $sp, 32
	jr $ra
