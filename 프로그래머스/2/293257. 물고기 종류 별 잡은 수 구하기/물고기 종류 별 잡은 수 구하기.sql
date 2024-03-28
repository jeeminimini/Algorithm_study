-- 코드를 작성해주세요
select count(b.fish_name) fish_count, b.fish_name from fish_info a, fish_name_info b
where a.fish_type = b.fish_type
group by b.fish_name
order by fish_count desc

