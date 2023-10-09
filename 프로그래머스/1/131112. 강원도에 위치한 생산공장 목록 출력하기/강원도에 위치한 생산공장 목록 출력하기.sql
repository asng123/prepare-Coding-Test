# 공장 ID, 공장 이름, 주소
# 강원도에 위치
# 공장 ID 기준 오름차순

select factory_id, factory_name, address
from food_factory
where substring(address,1,3) = '강원도'
order by factory_id