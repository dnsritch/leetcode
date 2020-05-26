#include <stdio.h>

// int maxProfit(int* prices, int pricesSize) {
//     int profit = 0;
//     for (int i = 0; i < pricesSize; i++)
//     {
//         for (int j = i + 1; j < pricesSize; j++)
//         {
//             if (prices[i] < prices[j])
//             {
//                 profit += prices[j] - prices[i];
//                 i = j-1;
//                 break;
//             }
//             else
//             {
//                 i = j - 1;
//                 break;
//             }
//         }
//     }
//     return profit;
// }
int maxProfit(int *prices, int pricesSize)
{
    int profit = 0, i;
    for (i = 0; i < pricesSize; i++)
    {
        if (i + 1 < pricesSize && (prices[i] < prices[i + 1]))
        {
            profit += prices[i + 1] - prices[i];
        }
    }
    return profit;
}

int main()
{
    int a[] = {7, 1, 5, 3, 6, 4};
    int b = maxProfit(a, 6);
    printf("%d", b);
    return 0;
}

// int maxProfit(int *prices, int pricesSize)
// {
//     int maxValue = 0;
//     int start = -1;
//     for (int i = 0; i < pricesSize; i++)
//     {
//         if (start == -1)
//         {
//             if (i + 1 < pricesSize && prices[i] < prices[i + 1])
//             {
//                 start = prices[i];
//             }
//         }
//         else
//         {
//             if ((i + 1 == pricesSize) || (i + 1 < pricesSize && prices[i] > prices[i + 1]))
//             {
//                 maxValue += prices[i] - start;
//                 start = -1;
//             }
//         }
//     }
//     return maxValue;
// }