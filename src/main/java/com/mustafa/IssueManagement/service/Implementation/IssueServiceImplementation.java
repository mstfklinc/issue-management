package com.mustafa.IssueManagement.service.Implementation;

import com.mustafa.IssueManagement.dto.IssueDto;
import com.mustafa.IssueManagement.entity.Issue;
import com.mustafa.IssueManagement.repository.IssueRepository;
import com.mustafa.IssueManagement.service.IssueService;
import com.mustafa.IssueManagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueServiceImplementation implements IssueService {

    //Burada constructor  Injection işlemi yapılmıştır.
    //Burada bulunan metodları aslında repository'de bulunan metodlarıon geniş halidir.
    //Bu yüzden İlgili repositotry'den bir constructor Injection yapılıyor.
    //Final olmasının sebebi runtime'da değişkenin değerinin değişmesini önlemek ve güvenliği sağlamak.
    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImplementation(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }


    //Servisten sonraki hiçbir katmanda Dto'larla konuşmuyoruz.
    //Ancak servis ve servisten api katmanına doğru çıkarken entitylerimizi dışarı çıkarmıyoruz.
    @Override
    public IssueDto save(IssueDto issue) {

        if(issue.getDate() == null){
            throw new IllegalArgumentException("Issue date cannot be null!");
        }

        //IssueDto tipinden bir instance'nin datasını, Issue tipinden bir class'ın instance koyup geri döndürür.
        Issue issueDb = modelMapper.map(issue, Issue.class);
        issueDb = issueRepository.save(issueDb);
        return modelMapper.map(issueDb,IssueDto.class);

    }

    @Override
    public IssueDto getById(Long id) {
        Issue issue = issueRepository.getOne(id);
        return modelMapper.map(issue, IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage<IssueDto> response = new TPage<IssueDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(),IssueDto[].class)));
        return response;
    }

    @Override
    public Boolean delete(Long issueId) {

        issueRepository.deleteById(issueId);
        return true;

    }

    @Override
    public IssueDto update(Long id, IssueDto project) {
        return null;
    }
}
