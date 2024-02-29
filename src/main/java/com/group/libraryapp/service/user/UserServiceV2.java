package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // UserRepository를 가져와서 save 메서드 호출
    // save 메서드에 객체를 넣어주면 insert sql이 자동으로 날라감
    // save되고 난 후의 User에는 id가 들어있음
    @Transactional
    public void saveUser(UserCreateRequest request){
        User u = userRepository.save(new User(request.getName(), request.getAge()));
        //return u.getId(); 를 하면 해당 id가 찍힘
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getUsers(){
        //findAll() 자동으로 sql을 날려 해당 테이블 데이터를 모두 가져옴
        return userRepository.findAll().stream()// 스트림으로 getter와 매핑
                // user 정보는 매핑한 User 객체가 됨. 이 객체를 UserResponse로 바꾸고
                // user -> new UserResponse(user.getId(), user.getName(), user.getAge()) -> UserResponse::new
                .map(UserResponse::new)
                // 전체 리스트로 바꾸어 반환
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateUser(UserUpdateRequest request){
        // select * from user where id= ?;
        // Optional<User>
        // findById : id를 기준으로 1개의 데이터를 가지고 옴
        User user = userRepository.findById(request.getId())
                // orElseThrow : 데이터(user)가 없는 경우 예외를 던짐
                .orElseThrow(IllegalArgumentException::new);

        //user가 있다면 실행
        // 객체를 업데이트 해주고 save 메서드 호출
        user.updateName(request.getName());
        // userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String name){
        User user = userRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);
        userRepository.delete(user);
    }

}
