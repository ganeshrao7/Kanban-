package com.niit.service;

import com.niit.exception.KanbanAlreadyExistException;
import com.niit.exception.KanbanNotFoundException;
import com.niit.exception.UserAlreadyExistsException;
import com.niit.model.*;

import java.util.List;
import java.util.Optional;

public interface KanbanService {

    public List<Kanban> getAllKanbanBoards();
    public Optional<Kanban> getKanbanById(int kanbanId);
    public  Optional<Kanban> getKanbanByTitle(String title);
    public Kanban saveNewKanban(KanbanDTO kanbanDTO);
    public Kanban updatekanban(Kanban oldkanban,KanbanDTO newkanban) ;
    public void deleteKanban(Kanban kanban) throws KanbanNotFoundException;
    public Kanban addNewTaskToKanban(int kanbanId, TaskDTO taskDTO);
    public Kanban saveKanban(Kanban kanban) throws KanbanAlreadyExistException;
    public Kanban updateTaskInKanban(int kanbanId,Task task);
    public Kanban updatekanban(Kanban kanban);
    public List<Kanban> getAllKanbanByEmail(String email);


    User registerUser(User user) throws UserAlreadyExistsException;

}
