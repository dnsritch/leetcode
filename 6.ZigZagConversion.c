#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// char *convert(char *s, int numRows)
// {
//     int strNum = strlen(s);
//     char *re = (char *)calloc(strNum, sizeof(char));
//     int zigCharNum = numRows + numRows - 2;
//     int zigNum = 0;
//     int num, offset;

//     char **temp;
//     int nclomns = (strNum / zigCharNum + 1) * (1 + numRows - 2);
//     temp = (char **)malloc(sizeof(char *) * numRows);
//     for (int i = 0; i < numRows; i++)
//     {
//         temp[i] = (char *)malloc(sizeof(char) * nclomns);
//         memset(temp[i], '\0', sizeof(char) * nclomns);
//         // temp[numRows][(strNum / zigCharNum + 1) * (1 + zigCharNum - 2)];
//     }

//     for (int i = 0; i < strNum; i++)
//     {
//         num = i / zigCharNum;
//         offset = i % zigCharNum;
//         if (offset > numRows - 1)
//         {
//             offset = offset - numRows + 1;
//             temp[numRows - offset - 1][(numRows - 1) * num + offset] = s[i];
//         }
//         else
//         {
//             temp[offset][(numRows - 1) * num] = s[i];
//         }
//     }
//     int tempi = 0;
//     for (int i = 0; i < numRows; i++)
//     {
//         for (int j = 0; j < nclomns; j++)
//         {
//             if (temp[i][j] != '\0')
//             {
//                 re[tempi] = temp[i][j];
//                 tempi++;
//             }
//             printf("%c", temp[i][j]);
//         }
//         printf("\n");
//     }
//     free(temp);
//     return re;
// }

char *convert(char *s, int numRows)
{
    int strNum = strlen(s);
    if (strNum == 0)
        return s;
    char *re = (char *)calloc(strNum + 1, sizeof(char));
    int zigCharNum = numRows + numRows - 2;

    int index = 0;
    for (int i = 0; i < numRows; i++)
    {
        for (int j = i; j < strNum; j++)
        {
            if (s[j] % zigCharNum == i || (zigCharNum - s[j] % zigCharNum == i))
            {
                re[index] = s[j];
                index++;
                j += zigCharNum - 1;
            }
        }
    }
    re[strNum] = '\0';
    return re;
}

int main()
{
    char s[] = "PAYPALISHIRING";
    char *re;
    re = (char *)malloc(sizeof(char) * 18);
    re = convert(s, 3);
    return 0;
}