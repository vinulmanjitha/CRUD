package com.example.demo.dao;

import com.example.demo.model.ACAEListDoneRQ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.*;

@Repository
public class ACAEBaseJdbcDAO {
    private static final Logger LOG = LoggerFactory.getLogger(ACAEBaseJdbcDAO.class);
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public String getEligibilityForwardACAEBatchRepository(ACAEListDoneRQ acaeListDoneRQ) {
        String execute = "";
        try {
            String sql = "{ ?= call CASV2APN.ACAE_OPERATIONS.IS_ACAE_LIST_DONE(?,?)}";

            List<SqlParameter> paramList = new ArrayList<>();
            paramList.add(new SqlOutParameter("RETURN_VALUE", Types.VARCHAR));
            paramList.add(new SqlParameter(Types.VARCHAR));
            paramList.add(new SqlParameter(Types.VARCHAR));

            Map<String, Object> resultMap = jdbcTemplate.call(
                    connection -> {
                        CallableStatement callableStatement = connection.prepareCall(sql);
                        callableStatement.registerOutParameter(1,  Types.VARCHAR);
                        callableStatement.setString(2, acaeListDoneRQ.getSolId());
                        callableStatement.setString(3, acaeListDoneRQ.getReferenceNumber());
                        return callableStatement;

                    }, paramList);
            LOG.info("resultMap"+resultMap);
            execute = (String) resultMap.get("RETURN_VALUE");
        } catch (Exception e) {
            LOG.error("ERROR : ", e);
        }
        return execute;
    }
}