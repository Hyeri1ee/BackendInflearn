package com.group.libraryapp.repository;

import com.group.libraryapp.domain.Fruit;
import com.group.libraryapp.dto.fruit.response.GetFruitResponseDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FruitJdbcRepository implements FruitRepository{
    private final JdbcTemplate jdbcTemplate;

    public FruitJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveFruitInfo(Fruit fruit) {
        String sql = "INSERT INTO other_fruits (name, warehousingDate,price) VALUES (?,?,?)";

        jdbcTemplate.update(sql, fruit.getName(),fruit.getWarehousingDate(),fruit.getPrice());
    }

    @Override
    public void updateFruitInfo(long id) {
        validateForUpdate(id);

        String sql = "UPDATE other_fruits SET is_sold = 1 WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

    //존재하지 않는 과일정보를 접근할 경우 Exception 발생
    private void validateForUpdate(long id) {
        if (isNotExistsFruitInfo(id)){
            throw new IllegalArgumentException("존재하는 과일정보가 없습니다.");
        }
    }

    @Override
    public GetFruitResponseDto getFruitInfo(String name) {
        String salesAmountSQL = "SELECT price FROM fruit WHERE name = ? AND is_sold = 1";
        List<Long> salesAmounts = jdbcTemplate.query(salesAmountSQL, new Object[]{name}, (rs, rowNum) -> rs.getLong("price"));
        long salesAmount = salesAmounts.stream().reduce(0L, Long::sum);

        String notSalesAmountSQL = "SELECT price FROM fruit WHERE name = ? AND is_sold = 0";
        List<Long> notSalesAmounts = jdbcTemplate.query(notSalesAmountSQL, new Object[]{name}, (rs, rowNum) -> rs.getLong("price"));
        long notSalesAmount = notSalesAmounts.stream().reduce(0L, Long::sum);

        validateGetFruitAmount(salesAmount, notSalesAmount);

        return new GetFruitResponseDto(salesAmount, notSalesAmount);
    }
    private void validateGetFruitAmount(long salesAmount, long notSalesAmount) {
        if (salesAmount == 0L && notSalesAmount == 0L) {
            throw new IllegalArgumentException("존재하는 과일이 없습니다.");
        }
    }

    private boolean isNotExistsFruitInfo(long id) {
        String readSQL = "SELECT * FROM fruit WHERE id = ?";

        return jdbcTemplate.query(readSQL, (rs, rowNum) -> 0, id).isEmpty();
    }

}
