class Solution {
    public int getSum(int a, int b) {

        // Keep going until there is no carry left.
        // Here, 'b' always represents the carry from the previous iteration.
        while (b != 0) {

            // AND finds all positions where both bits are 1.
            // Those positions generate a carry.
            // Shift left because the carry belongs to the next higher bit.
            int carry = (a & b) << 1;

            // XOR adds the bits without considering the carry.
            // It gives the correct bit for the current position.
            a = a ^ b;

            // Add the carry in the next iteration.
            b = carry;
        }

        // When there is no carry left, 'a' contains the final sum.
        return a;
    }
}