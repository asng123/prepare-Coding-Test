# animal_ins = 동물보호소에 들어온 동물의 정보
# 아이디, 타입, 날짜, 상태, 이름, 중성화

select count(distinct name) count
from animal_ins
where name is not null