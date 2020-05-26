#include <stdio.h>
#include <stdlib.h>

int removeElement(int *nums, int numsSize, int val)
{
    if (numsSize == 0)
        return 0;
    if (numsSize == 1 && nums[0] == val)
        return 0;

    int flag = 0;
    for (int i = 0; i < numsSize; i++)
    {
        if (nums[i] != val)
        {
            nums[flag] = nums[i];
            flag++;
        }
    }
    return flag;
}

int main()
{
    int a[5] = {1, 11, 1, 3, 2};
    int b = removeElement(a, 5, 1);
    return 0;
}