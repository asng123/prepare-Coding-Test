# food product : 식품 정보
# 식품id, 이름, 코드, 분류, 가격


select category, price, product_name
from food_product
where category in ('과자', '국', '김치', '식용유') 
    and (price,category) in (select max(price), category
                          from food_product
                          group by category)
order by price desc