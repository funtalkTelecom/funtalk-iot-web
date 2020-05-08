package com.funtalk.mapper;

import com.funtalk.pojo.Task;
import org.apache.ibatis.annotations.Param;

public interface TaskMapper {


    int insert(Task record);

    int updateTaskCount(@Param(value = "taskId") Long taskId,
                        @Param(value = "taskCount") Integer taskCount);

}
