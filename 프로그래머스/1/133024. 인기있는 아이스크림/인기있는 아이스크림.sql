# 상반기에 판매가 된 
#아이스크림의 맛을 
#총 주문량 기준 내림차순 후 출하 번호 기준 오름차순

select flavor
from first_half
order by total_order desc, shipment_id 