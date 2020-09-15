#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int main()
{
    if (x == -2147483648)
        return 0;
    long MAX = pow(2, 31) - 1;
    long MIN = 0 - pow(2, 31);

    char str[12] = {0};
    long b;

    int x = -2147483412;

    int flag = x > 0 ? 1 : 0;
    x = x > 0 ? x : -x;
    // itoa(x, str, 10);
    sprintf(str, "%d", x);
    int length = strlen(str), temp;

    for (int i = 0; i < length / 2; i++)
    {
        temp = str[i];
        str[i] = str[length - 1 - i];
        str[length - 1 - i] = temp;
    }
    b = atol(str);
    b = flag > 0 ? b : -b;
    b = (b <= MAX && b >= MIN) ? b : 0;
    printf("%d", b);
    // b = (int)b;
    return b;
}