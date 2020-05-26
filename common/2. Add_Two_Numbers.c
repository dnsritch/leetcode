/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode
{
    int val;
    struct ListNode *next;
};

struct ListNode *addTwoNumbers(struct ListNode *l1, struct ListNode *l2)
{
    struct ListNode *head, *this;
    int carry = 0, sum, temp1, temp2;
    head = calloc(1, sizeof(struct ListNode));
    this = head;
    while (l1 || l2)
    {
        temp1 = l1 ? l1->val : 0;
        temp2 = l2 ? l2->val : 0;
        sum = temp1 + temp2 + carry;
        carry = sum / 10;

        if (l1)
            this->next = l1;
        else
            this->next = l2;
        this->next->val = sum % 10;
        this = this->next;

        if (l1)
            l1 = l1->next;
        if (l2)
            l2 = l2->next;
    }
    if (carry != 0)
    {
        this->next = calloc(1, sizeof(struct ListNode));
        this->next->val = 1;
        this->next->next = NULL;
    }
    struct LinkNode *temp = head->next;
    free(head);
    return temp;
}

// struct ListNode *addTwoNumbers(struct ListNode *l1, struct ListNode *l2)
// {
//     struct ListNode *head, *this;
//     int carry = 0, sum, temp1, temp2;
//     head = calloc(1, sizeof(struct ListNode));
//     this = head;
//     while (l1 || l2)
//     {
//         temp1 = (l1 != NULL) ? l1->val : 0;
//         temp2 = (l2 != NULL) ? l2->val : 0;
//         sum = temp1 + temp2 + carry;
//         carry = sum / 10;

//         this->next = calloc(1, sizeof(struct ListNode));
//         this->next->val = sum % 10;
//         this = this->next;
//         this->next = NULL;

//         if (l1)
//             l1 = l1->next;
//         if (l2)
//             l2 = l2->next;
//     }
//     if (carry != 0)
//     {
//         this->next = calloc(1, sizeof(struct ListNode));
//         this->next->val = 1;
//         this->next->next = NULL;
//     }
//     struct LinkNode *temp = head->next;
//     free(head);
//     return temp;
// }

// struct ListNode *addTwoNumbers(struct ListNode *l1, struct ListNode *l2)
// {
//     struct ListNode *p, *q;
//     p = l1;
//     q = l2;
//     int flag = 0, temp;
//     while (p && q)
//     {
//         temp = p->val + q->val > 9 ? p->val + q->val - 10 : p->val + q->val;
//         temp = flag ? temp += 1 : temp; //进位
//         flag = p->val + q->val > 9 ? 1 : 0;
//         p->val = temp;

//         if (p->next && !q->next)
//         {
//             while (p->next)
//             {
//                 p->next->val = flag ? p->next->val += 1 : p->next->val;
//                 if(p->next->val>9){
//                     p->next->val
//                 }
//                 break;
//             }
//         }
//         else if (!p->next && q->next)
//         {
//             q->next->val = flag ? q->next->val += 1 : q->next->val;
//             p->next = q->next;
//             break;
//         }
//         else if (!p->next && !q->next && flag)
//         {
//             struct ListNode *this;
//             this = calloc(1, sizeof(struct ListNode));
//             this->val = 1;
//             this->next = NULL;
//             p->next = this;
//             break;
//         }
//         else
//         {
//             p = p->next;
//             q = q->next;
//         }
//     }
//     return l1;
// }