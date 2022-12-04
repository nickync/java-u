arr = [4, 6, 0, 1, 2, 5, 9, 7, 3]
arr1 = [1, 2, 3, 9, 4, 11, 0, 4, 1, 0, 99, 33]
arr2 = [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]


def mergeSort(arr):

    if (len(arr) > 1):

        left = arr[:(len(arr)//2)]
        right = arr[(len(arr)//2):]

        mergeSort(left)
        mergeSort(right)

        i = 0
        j = 0
        k = 0

        while (i < len(right) and j < len(left)):
            if (right[i] >= left[j]):
                arr[k] = left[j]
                j += 1
            else:
                arr[k] = right[i]
                i += 1

            k += 1

        while (i < len(right)):
            arr[k] = right[i]
            i += 1
            k += 1

        while (j < len(left)):
            arr[k] = left[j]
            j += 1
            k += 1

    return arr


print(mergeSort(arr))
print(mergeSort(arr1))
print(mergeSort(arr2))
