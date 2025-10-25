package org.example.task4;

class Worker {
    private boolean active = true;

    public boolean isActive() { return active; }
    public void work() { active = false; }
    public void rest() { active = true; }
}