# 상반기 주문정보
# 7월 주문정보

#7월 총 주문량과 상반기 아이스크림 총 주문량을 더한 값이 큰 순서대로 상위 3개의 맛을 조회

select o.flavor
from first_half o 
join july j
on o.flavor = j.flavor
group by o.flavor
order by sum(o.total_order) + sum(j.total_order) desc
limit 3
