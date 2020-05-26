char get_char(char *s, int index, int length)
{
    if (index < length)
        return *(s + index);
    else
        return '\0';
}

bool isMatch(char *s, char *p)
{
    int s_length = strlen(s);
    int p_length = strlen(p);
    if (s_length == 0 || p_length == 0)
        return false;
    int index = 0;
    for (int i = 0; i < s_length; i++)
    {
        if (s[i] == get_char(p, index, p_length) || get_char(p, index, p_length) == '.')
        {
            index++;
        }
        else if (get_char(p, index, p_length) == '*')
        {
            if (s[i] == get_char(p, index - 1, p_length) || get_char(p, index - 1, p_length) == '.')
            {
            }
            else
            {
                index++;
                i--;
            }
        }
        else if (get_char(p, index + 1, p_length) == '*')
        {
            i--;
            index++;
        }
        else
        {
            return false;
        }
    }
    if (index + 1 == p_length)
        return true;
    else
        return false;
}