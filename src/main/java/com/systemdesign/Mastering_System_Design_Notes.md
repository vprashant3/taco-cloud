# Mastering System Design Interview

## Designing Systems That Scale

### Horizontal vs Vertical Scaling
    - Vertical Scaling : increases server size, not very useful and still keeps a single point of failure.
    - Horizontal Scaling : better than vertical and duplicate servers are placed behind a load balancer.
    - Try to make your service state less, which means any server can handler any request. 
    - DB can be used to tie all the requests and maintain history.
    - Choose the simplest architecture that meets your requirements, no simpler than that.

### Failover Strategies
    - Failover Servers : cold standby
    - 
    