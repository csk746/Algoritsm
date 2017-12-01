
zero = 0
one = 0
def fibo(n):

    if n==0:
        global zero
        zero+=1
        return 0
    elif n==1:
        global one
        one+=1
        return 1
    else:
        return fibo(n-1) + fibo(n-2)

tc = int(input())

for i in range(0,tc):
    case = int(input())
    result = fibo(case)
    print(str(zero)+' '+str(one))
    zero = 0
    one = 0

