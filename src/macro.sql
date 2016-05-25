select 
	m1.id_obj, count(*) 
from 
	macroeconomic_160429 as m1,
	macroeconomic_160430 as m2 
where 
	m1.id_obj = m2.id_obj and 
	m1.id_obj in (1371, 1372) and 
	m1.action = m2.action and
	m1. action =  'build_building' 
group by id_obj;
	