# 식품정보 food_product {식품id, 이름, 코드 ,분류, 가격}
# 주문정보 food_order {주문id, 식품id, 주문량, 생산일, 입고일, 출고일, 공장id, 창고 id}

# 2022 5월에 생산한 식품들의 id, 이름, 총매출
# 총매출 기준 desc, 식품id 기준 오름차순

select p.product_id PRODUCT_ID, p.product_name PRODUCT_NAME, sum(p.price * o.amount) TOTAL_SALES
from food_product p
join food_order o
on p.product_id = o.product_id
where o.produce_date like '2022-05%'
group by p.product_id
order by TOTAL_SALES desc, PRODUCT_ID