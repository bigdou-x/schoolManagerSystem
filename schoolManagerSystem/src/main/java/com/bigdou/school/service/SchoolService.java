package com.bigdou.school.service;

import com.bigdou.school.entity.Result;
import com.bigdou.school.entity.School;
import com.bigdou.school.type.ErrorCodeEnum;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ExecutableUpdateOperation;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


/**
 * <P>文件描述：学校业务层</P>
 *
 * @author xuqing
 * @version V1.0
 * @date 2019-8-18 17:15:55
 */
@Service
@Slf4j
public class SchoolService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Result addSchool(School school) {
        Result result = new Result();
        mongoTemplate.save(school);
        log.debug("addSchool param is {}", school);
        return result;
    }

    public Result modifySchool(School school) {
        Result result = new Result();
        UpdateResult updateResult = mongoTemplate.updateFirst(query(where("id").is(school.getId())),
                new Update().set("caption", school.getCaption())
                        .currentDate("updateTime"),
                School.class);
        log.debug("modifySchool param is {}, result is {}", school, updateResult);
        return result;
    }

    public Result deleteSchool(School school) {
        Result result = new Result();
        DeleteResult deleteResult = mongoTemplate.remove(school);
        log.debug("deleteSchool param is {}, result is {}", school, deleteResult);
        return result;
    }

    public Result getSchools(String schoolId) {
        Result result = new Result();
        List<School> schoolList = mongoTemplate.find(query(where("schoolId").is(schoolId)),
                            School.class);
        result.setContent(schoolList);
        result.setRet(ErrorCodeEnum.OK.ordinal());
        return result;
    }

}
