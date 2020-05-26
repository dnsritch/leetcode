#include <stdio.h>
#include <stdlib.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int *twoSum(int *nums, int numsSize, int target)
{
    int *re;
    // re = (int *)malloc(sizeof(int) * 2);
    re = calloc(2, sizeof(int));
    for (int i = 0; i < numsSize; i++)
    {
        for (int j = i + 1; j < numsSize; j++)
        {
            if (nums[i] + nums[j] == target)
            {
                re[0] = i;
                re[1] = j;
                break;
            }
        }
    }
    return re;
}

int main()
{

    return 0;
}