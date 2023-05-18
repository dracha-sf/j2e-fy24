def findKthLargest(nums, k):
    k = len(nums) - k
    left, right = 0, len(nums) - 1

    while left <= right:
        pivot_index = partition(nums, left, right)
        if pivot_index == k:
            return nums[pivot_index]
        elif pivot_index < k:
            left = pivot_index + 1
        else:
            right = pivot_index - 1

def partition(nums, left, right):
    pivot = nums[right]
    i = left

    for j in range(left, right):
        if nums[j] <= pivot:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1

    nums[i], nums[right] = nums[right], nums[i]
    return i


nums = [3, 2, 1, 5, 6, 4]
k = 2
kth_largest = findKthLargest(nums, k)
print(kth_largest)
