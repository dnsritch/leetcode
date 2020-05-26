int lengthOfLongestSubstring(char *s)
{
    int num = strlen(s);
    int count = 0, max = num;
    for (int k = 0; k < num; k++)
    {
        if (num - k + 1 < count)
            break;
        for (int i = k; i < max; i++)
        {
            for (int j = i + 1; j < max; j++)
            {
                if (s[i] == s[j])
                {
                    max = j;
                    break;
                }
            }
        }
        int temp = max - k;
        count = (temp > count) ? temp : count;
        max = num;
    }
    return count;
}