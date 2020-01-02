package com.shf.sso.server.security.exception;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.util.Map;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/9 11:30
 * @Version V1.0
 **/
public class PrexCustomOauthExceptionSerializer extends StdSerializer<PrexCustomOauthException> {

    public PrexCustomOauthExceptionSerializer() {
        super(PrexCustomOauthException.class);
    }

    @Override
    public void serialize(PrexCustomOauthException value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("code", value.getHttpErrorCode());
        String errorMessage = value.getErrorCode();
        if (errorMessage != null) {
            errorMessage = HtmlUtils.htmlEscape(errorMessage);
        }
        gen.writeStringField("msg", errorMessage);
        if (value.getAdditionalInformation() != null) {
            for (Map.Entry<String, String> entry : value.getAdditionalInformation().entrySet()) {
                String key = entry.getKey();
                String add = entry.getValue();
                gen.writeStringField(key, add);
            }
        }
        gen.writeEndObject();
    }
}
