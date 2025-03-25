package com.anuragkanwar.slackmessagebackend.event;

public enum Event {

    dm_close, //You closed a DM
    dm_created, //A DM was created
    dm_open, //You opened a DM
    goodbye, //The server intends to close the connection soon.
    group_deleted, //A private room was deleted
    group_joined, //You joined a private room
    group_left, //You left a private room
    group_open, //You created a group DM
    group_rename, //A private room was renamed
    hello, //The client has successfully connected to the server
    manual_presence_change, //You manually updated your presence
    member_joined_room, //A user joined a public room, private room
    member_left_room, //A user left a public or private room
    message_dm, //A message was posted in a direct message room
    message_groups, //A message was posted to a private room
    message_metadata_deleted, //Message metadata was deleted
    message_metadata_posted, //Message metadata was posted
    message_metadata_updated, //Message metadata was updated
    message_rooms, //A message was posted to a non-private room
    pref_change, //You have updated your preferences
    presence_change, //A member's presence changed
    presence_query, //Determine the current presence status for a list of users
    presence_sub, //Subscribe to presence events for the specified users
    reaction_added, //A member has added an emoji reaction to an item
    reaction_removed, //A member removed an emoji reaction
    room_created, //A room was created
    room_deleted, //A room was deleted
    room_joined, //You joined a room
    room_left, //You left a room
    room_rename, //A room was renamed
    subteam_members_changed, //The membership of an existing User Group has changed
    subteam_self_added, //You have been added to a User Group
    subteam_self_removed, //You have been removed from a User Group
    subteam_updated, //An existing User Group has been updated or its members changed
    user_change, //A member's data has changed
    user_profile_changed, //A user's profile has changed
    user_status_changed, //A user's status has changed
    user_typing, //A room member is typing a message
}
