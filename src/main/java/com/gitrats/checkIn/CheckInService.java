package com.gitrats.checkIn;

import org.springframework.data.repository.core.support.RepositoryMethodInvocationListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckInService {

    private final RepositoryMethodInvocationListener repositoryMethodInvocationListener;
    private CheckInRepository checkInRepository;

    public CheckInService(CheckInRepository checkInRepository, RepositoryMethodInvocationListener repositoryMethodInvocationListener) {
        this.checkInRepository = checkInRepository;
        this.repositoryMethodInvocationListener = repositoryMethodInvocationListener;
    }

    public CheckIn createCheckIn(CheckIn post){
        return checkInRepository.save(post);
    }

    public void deleteCheckIn(Long id){
        checkInRepository.deleteById(id);
    }

    public CheckIn updateCheckIn(Long id, CheckIn postUpdate){
        Optional<CheckIn> postOpt = checkInRepository.findById(id);

        if (postOpt != null){
            CheckIn post = postOpt.get();
            if(postUpdate.getTitle() != null) post.setTitle(postUpdate.getTitle());
            if(postUpdate.getDescription() != null) post.setDescription(postUpdate.getDescription());
            if(postUpdate.getTitleType() != null) post.setTitleType(postUpdate.getTitleType());

            return checkInRepository.save(post);
        }
        return null;
    }

    public CheckIn listCheckInId(Long id){
        Optional<CheckIn> checkIn = checkInRepository.findById(id);
        return checkIn.orElse(null);
    }

    public List<CheckIn> listCheckIn(){
        return checkInRepository.findAll();
    }

}

