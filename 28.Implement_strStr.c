#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int strStr(char *haystack, char *needle)
{
    return indexOf()
}

int main()
{
    return 0;
}

int indexOf(char *str, char ch)
{
    int index = 0;
    char tmp = str[index];
    // 当这个字符还不是最后一个字符时做判断
    while (tmp != ‘\0’)
    {
        if (tmp == ch)
        {
            return index;
        }
        index++;
        tmp = str[index];
    }
    //找不到则返回 -1
    return -1;
}
