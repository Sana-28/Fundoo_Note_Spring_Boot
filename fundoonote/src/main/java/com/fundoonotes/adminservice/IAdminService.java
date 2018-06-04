package com.fundoonotes.adminservice;

import java.util.List;

import com.fundoonotes.utility.UserNotedDto;

public interface IAdminService
{
   public List<UserNotedDto> getUserNoteCount();

   public void login(AdminDto adminDto);
}
