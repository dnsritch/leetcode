#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int checkChar(char *a, int num, int start, int end)
{
    while (start >= 0 && end < num && a[start] == a[end])
    {
        start--;
        end++;
    }
    return end - start - 1;
}

char *longestPalindrome(char *s)
{
    int num = strlen(s);
    if (num == 0)
        return "";
    int count = 1, start = 0, end = 0;
    for (int k = 0; k < num / 2 + 1; k++)
    {
        int len1 = checkChar(s, num, k, k);
        int len2 = checkChar(s, num, k, k + 1);

        if (len1 >= len2 && len1 > count)
        {
            start = k - len1 / 2;
            end = k + len1 / 2;
            count = len1;
        }
        if (len2 > len1 && len2 > count)
        {
            start = k - len2 / 2 + 1;
            end = k + len2 / 2;
            count = len2;
        }
    }
    // char *re;
    // re = (char *)malloc(sizeof(char) * (end - start + 1));
    // for (int i = start; i < end + 1; i++)
    // {
    //     re[i - start] = s[start + i];
    // }
    // return re;
    for (int i = 0; i < end - start + 1; i++)
    {
        s[i] = s[start + i];
    }
    s[end - start + 1] = '\0';
    return s;
}

int main()
{
    char s[] = "bbbb";
    char *re = longestPalindrome(s);
    return 0;
}