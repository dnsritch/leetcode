typedef int bool;
#define TRUE 1;
#define FALSE 0;

bool isPalindrome(int x)
{
    if (x < 0)
        return FALSE;
    char str[12];
    sprintf(str, "%d", x);
    int length = strlen(str);
    for (int i = 0; i < length / 2; i++)
    {
        if (str[i] != str[length - 1 - i])
            return FALSE;
    }
    return TRUE;
}