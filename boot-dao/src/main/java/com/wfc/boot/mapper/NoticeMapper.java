package com.wfc.boot.mapper;

import com.wfc.boot.entity.Notice;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface NoticeMapper extends Mapper<Notice> {

}