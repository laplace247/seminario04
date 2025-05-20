

#ejercicio05
#ingresar 15 notas del 0 al 20
#si es >10 aprobado, caso contrario
#desaprobado, mostrar cuantos son aprobados
#y cuantos desaprobados

desaprobado=0
aprobado=0
n=int(input("Cuantas notas se ingresara?:"))
for x in range(n):
    num1=int(input("Ingresa un nota:"))
    if num1>10:
        aprobado=aprobado+1
    else:
        desaprobado=desaprobado+1
        
print("Los aprobados son:",aprobado)
print("Los desaprobados son:",desaprobado)

#investigar     
#Scikit Learn
#Pytorch
