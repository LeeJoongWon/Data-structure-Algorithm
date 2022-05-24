# 퀵 정렬

다른 원소와의 비교만으로 정렬을 수행하는 비교 정렬에 속한다.

퀵 정렬은 분할 정복(divide and conquer) 방법을 통해 리스트를 정렬한다.

리스트 가운데서 하나의 원소를 고른다. 이렇게 고른 원소를 피벗이라고 한다.

피벗 앞에는 피벗보다 값이 작은 모든 원소들이 오고, 피벗 뒤에는 피벗보다 값이 큰 모든 원소들이 오도록 피벗을 기준으로 리스트를 둘로 나눈다. 

이렇게 리스트를 둘로 나누는 것을 분할이라고 한다. 분할을 마친 뒤에 피벗은 더 이상 움직이지 않는다.

분할된 두 개의 작은 리스트에 대해 재귀(Recursion)적으로 이 과정을 반복한다. 재귀는 리스트의 크기가 0이나 1이 될 때까지 반복된다.

재귀 호출이 한번 진행될 때마다 최소한 하나의 원소는 최종적으로 위치가 정해지므로, 이 알고리즘은 반드시 끝난다는 것을 보장할 수 있다.