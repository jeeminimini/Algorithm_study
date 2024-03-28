-- 코드를 작성해주세요
select item_id, item_name, rarity from item_info
where item_id in (
    select b.item_id from item_info a
    left join item_tree b on a.item_id = b.PARENT_ITEM_ID
    where a.RARITY = 'RARE' and b.item_id is not null
)
order by item_id desc