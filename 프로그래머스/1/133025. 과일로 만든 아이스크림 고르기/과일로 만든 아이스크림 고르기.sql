# 키: flavor
# 아이스크림의 맛을 조회
# 총주문량 > 3000 and 주성분 = 과일
# 총주문량이 큰 순서대로 => 내림차순

select f.flavor
from first_half f, icecream_info i
where f.total_order>3000 and f.flavor = i.flavor and i.ingredient_type = 'fruit_based'
order by f.total_order desc