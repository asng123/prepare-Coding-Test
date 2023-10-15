# 동물보호소에 들어온 동물정보
# 동물 보호소에서 입양보낸 동물 정보

#입양 못간 동물중 가장 오래 보호소에 있었떤 동물 3마리의

select i.name, i.datetime
from animal_ins i
left join animal_outs o
on i.animal_id = o.animal_id
where o.animal_id is null
order by i.datetime
limit 3