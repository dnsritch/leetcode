/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {Node} root
 * @return {number}
 */
var maxDepth = (root) => (root ? 1 + Math.max(...(root.children || []).map((item) => maxDepth(item)), 0) : 0) 
