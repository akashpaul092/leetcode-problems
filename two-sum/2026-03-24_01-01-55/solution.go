func twoSum(nums []int, target int) []int {
    m := make(map[int]int)

    for index, value := range nums {
        remain := target - value
        val, exists := m[remain]
        if exists {
            return []int{val, index}
        }
        m[value] = index
    }
    return []int{-1,-1}
}