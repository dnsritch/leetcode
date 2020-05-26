#include <stdio.h>
#include <stdlib.h>

int removeDuplicates(int *nums, int numsSize)
{
    if (numsSize == 0)
        return 0;
    if (numsSize == 1)
        return 1;

    int flag;
    flag = *nums;

    for (int i = 1; i < numsSize; i++)
    {
        if (*(nums + i) == flag)
        {
            *(nums + i) = -1000;
        }
        else
        {
            flag = *(nums + i);
        }
    }

    flag = 0;
    for (int i = 1; i < numsSize; i++)
    {
        if (*(nums + i) == -1000)
        {
            flag += 1;
        }
        else
        {
            *(nums + i - flag) = *(nums + i);
            if (flag != 0)
                *(nums + i) = -1000;
        }
    }
    flag = 0;
    for (int i = 0; i < numsSize; i++)
    {
        if (*(nums + i) != -1000)
        {
            flag += 1;
        }
        else
        {
            return flag;
        }
    }
    return flag;
}

// int removeDuplicates(int *nums, int numsSize)
// {
//     if (numsSize == 0)
//         return 0;
//     if (numsSize == 1)
//         return 1;
//     int count = 1;
//     for (int i = 1; i < numsSize; i++)
//     {
//         if (nums[i] - nums[i - 1] != 0)
//         {
//             nums[count] = nums[i];
//             count++;
//         }
//     }
//     return count;
// }

int main()
{
    int a[4] = {1, 2, 3, 4};
    int *b = a;
    for (int i = 0; i < 4; i++)
    {
        printf("%d\n", b[i]);
    }
    printf("%d\n", *a);
    printf("%d\n", b);
    printf("%d\n", *(b + 1));

    int a[3] = {1, 2, 3};

    int b = removeDuplicates(a, 3);
    printf("%d", b);
    printf("%d", &b);
}
