package umc.spring.service;

import org.springframework.stereotype.Service;

@Service
public interface TempQueryService {

    void CheckFlag(Integer flag);
}