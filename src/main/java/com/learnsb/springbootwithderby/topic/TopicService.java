package com.learnsb.springbootwithderby.topic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
        new Topic(1, "Spring Framework", "Spring Framework Description"),
        new Topic(2, "Java", "Java Description"),
        new Topic(3, "Python", "Python Description")
    ));

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
        .forEach(topics::add);
        return topics;
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public Topic getTopic(int id) {
        return topicRepository.findById(id).get();
    }

    public void updateTopic(int id, Topic topic) {
        topicRepository.save(topic);
    }
    
    public void deleteTopic(int id) {
        topicRepository.deleteById(id);
    }
}
