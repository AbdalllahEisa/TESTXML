package com.example.demo;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.DataInput;
import java.io.IOException;
import java.util.Base64;

@RestController
public class ApiController {



    @GetMapping(path = "convert",produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> conversionmethode(){
        String json=null;

        String data="PFRlc3Q+CjxuYW1lPmFiZGFsbGFoPC9uYW1lPgo8aWQ+MTAxPC9pZD4KPHRlc3Rlcj5tb2hhbWVkPC90ZXN0ZXI+CjwvVGVzdD4=";
       try{     byte[] decodedBytes = Base64.getDecoder().decode(data);
            String decodedString = new String(decodedBytes);
            XmlMapper xmlMapper = new XmlMapper();
            Test entries = xmlMapper.readValue(decodedString, Test.class);



            ObjectMapper jsonMapper = new ObjectMapper();
             json = jsonMapper.writeValueAsString(entries);


        } catch (JsonParseException e)
        {
            e.printStackTrace();
        } catch (JsonMappingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }


           return ResponseEntity.ok(json);
    }}
