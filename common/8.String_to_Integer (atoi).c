int myAtoi(char *str)
{
    int length = strlen(str);
    int flag = 0, start = 0;
    long value = 0;
    int overflow = 0;
    for (int i = 0; i < length; i++)
    {
        if (str[i] == ' ' && !start)
        {
            continue;
        }
        else if (str[i] == '+' && !start)
        {
            start = 1;
        }
        else if (str[i] == '-' && !start && !flag)
        {
            start = 1;
            flag = 1;
        }
        else if (str[i] >= '0' && str[i] <= '9')
        {
            start = 1;
            if (value * 10 + str[i] - 48 > pow(2, 31))
            {
                overflow = 1;
                break;
            }
            value = value * 10 + str[i] - 48;
        }
        else
        {
            break;
        }
    }
    if (overflow)
        if (!flag)
            return pow(2, 31);
        else
            return -pow(2, 31) - 1;

    value = flag ? -value : value;
    value = value > pow(2, 31) - 1 ? pow(2, 31) - 1 : value;
    value = value < -pow(2, 31) ? -pow(2, 31) : value;
    return (int)value;
}