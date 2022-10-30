arr = [4,6,0,1,2,5,9,7,3]
arr1 = [1,2,3,9,4,11,0,4,1,0,99,33]

def selectionSort(arr):
    for i in range(len(arr)-1):
        min = arr[i]
        temp = 0
        j = i
        while j < len(arr):
            if (min > arr[j]):
                min = arr[j]
                temp = j
            j += 1

        if (min != arr[i]):
            arr[i], arr[temp] = min, arr[i]
    return arr

print(selectionSort(arr))
print(selectionSort(arr1))



