package com.internship.array_task.repository;

import com.internship.array_task.model.IntArray;
import com.internship.array_task.spec.AggregateCompareSpecification;
import com.internship.array_task.spec.NameEqualsSpecification;
import com.internship.array_task.warehouse.ArrayMetrics;
import com.internship.array_task.warehouse.Warehouse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class ArrayRepositoryWarehouseTest {
    @Test
    void add_update_remove_triggersWarehouseAndQueries() {
        ArrayRepository repo = ArrayRepository.getInstance();
        Warehouse wh = Warehouse.getInstance();
        repo.clear();
        wh.clear();

        IntArray a = IntArray.named("a", 1, 2);
        IntArray b = IntArray.named("b", 3);
        repo.add(a);
        repo.add(b);

        ArrayMetrics m1 = wh.getMetrics(a);
        ArrayMetrics m2 = wh.getMetrics(b);
        Assertions.assertEquals(3L, m1.getSum());
        Assertions.assertEquals(3L, m2.getSum());

        IntArray a2 = IntArray.named("a", 10, 20);
        repo.update(a, a2);
        Assertions.assertNull(wh.getMetrics(a));
        Assertions.assertEquals(30L, wh.getMetrics(a2).getSum());

        List<IntArray> byName = repo.query(new NameEqualsSpecification("b"));
        Assertions.assertEquals(1, byName.size());

        AggregateCompareSpecification spec = new AggregateCompareSpecification(
                new com.internship.array_task.service.impl.ArrayStatsServiceImpl(),
                AggregateCompareSpecification.Metric.SUM,
                AggregateCompareSpecification.Op.GT,
                10
        );
        List<IntArray> gt10 = repo.query(spec);
        Assertions.assertEquals(1, gt10.size());

        List<IntArray> sortedByName = repo.sort(ArrayComparators.BY_NAME);
        Assertions.assertEquals("a", sortedByName.get(0).getName());

        repo.remove(a2);
        Assertions.assertNull(wh.getMetrics(a2));
    }
}