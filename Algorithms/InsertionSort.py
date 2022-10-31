arr = [4, 6, 0, 1, 2, 5, 9, 7, 3]
arr1 = [1, 2, 3, 9, 4, 11, 0, 4, 1, 0, 99, 33]
arr2 = [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]


def insertionSort(arr):
    for i in range(len(arr)-1):
        temp = 0
        while (arr[i+1] < arr[i] | i > 0):
            temp = arr[i+1]
            arr[i+1] = arr[i]
            arr[i] = temp
            i -= 1
    return arr


print(insertionSort(arr))
print(insertionSort(arr1))
print(insertionSort(arr2))
